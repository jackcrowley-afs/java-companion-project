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
				
				return mglService.updateGame(game1.id).then( function() {
				self.fetchAllGames();
				});
			}

			self.fetchAllGames();
		} ]);
