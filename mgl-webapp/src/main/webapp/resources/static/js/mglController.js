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
			
			self.deleteGame = function(){
				
				console.log("Delete function with ID of ");
			}

			self.fetchAllGames();
		} ]);
