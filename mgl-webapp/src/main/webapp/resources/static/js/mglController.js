'use strict';

angular.module('GameApp').controller('mglController',
		[ 'mglService', function(mglService) {
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
				});
			}

			self.addGame = function(){
				return mglService.createGame(self.game).then( function() {
				self.fetchAllGames();
				});
			}
			
			self.deleteGame = function(game1){
				
				console.log("Delete function with ID of " + game1.id);
				
				return mglService.deleteGame(game1.id).then( function() {
				self.fetchAllGames();
				});
				
			}
			
			self.updateGame = function(game1){
				
				console.log("Update Game with ID of " + game1.id);
				
				console.log("Game Name in Text Field: " + self.game.name);
				console.log(self.game.genre);
				
				return mglService.updateGameById(game1.id, self.game.name, self.game.genre).then( function() {
				self.fetchAllGames();
				});
				
				
				
			}
			
			self.getGamesByGenre = function(){
				
				
				console.log(self.filterGenre);
				
				
				return mglService.getGamesByGenre(self.filterGenre);
				
			}

			self.fetchAllGames();
		} ]);
