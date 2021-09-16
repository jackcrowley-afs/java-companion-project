'use strict';

angular.module('GameApp').controller('mglController',
		[ 'mglService', function(mglService) {
			
			const MINLENGTH = 3; 
			
			var self = this;
			self.game = {
				game_id : '',
				game_name : '',
				game_genre : ''
			};
			self.games = [];
			
			self.filterGenre = '';

			self.fetchAllGames = function(){
				mglService.fetchAllGames().then(function(data) {
					self.games = data;
				}).finally(function(){
					
					self.clearFields();
				});
			}

			self.addGame = function(){
				
				console.log(self.game.name.length)
				
		//		if(self.game.name.length < MINLENGTH || self.game.genre.length < MINLENGTH)
		//		{
		//			self.clearFields();
		//			return;
		//		}
				
				
				return mglService.createGame(self.game).then( function() {
				self.fetchAllGames();
				});
			}
			
			self.deleteGame = function(game1){
				
				return mglService.deleteGame(game1.id).then( function() {
				self.fetchAllGames();
				});
				
			}
			
			self.updateGame = function(game1){
				
				return mglService.updateGameById(game1.id, self.game.name, self.game.genre).then( function() {
				self.fetchAllGames();
				});

			}
			
			self.getGamesByGenre = function(){
				
				
				console.log(self.filterGenre);
				
				if(self.filterGenre === "")
				{
					
					return self.fetchAllGames();
				}
				
				
				return mglService.getGamesByGenre(self.filterGenre).then( function(data) {
				
				self.games = data;
				
				self.filterGenre = '';
				
				});
				
			}
			
			self.clearFields = function(){
				
				self.game.name = '';
				self.game.genre = '';
			}
			

			self.fetchAllGames();
		} ]);
