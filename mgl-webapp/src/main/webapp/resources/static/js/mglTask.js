'use strict';

angular.module('GameApp').factory('mglService', ['$http', function($http) {

		var REST_SERVICE_URI = 'game/';

		var factory = {
			fetchAllGames : fetchAllGames,
			createGame : createGame,
			deleteGame: deleteGame,
			updateGameById: updateGameById,
			getGamesByGenre: getGamesByGenre
		};

		return factory;

		function fetchAllGames() {
			return $http.get(REST_SERVICE_URI).then(function(response) {
					return response.data;
				}
			);
		}

		function createGame(game) {
			return $http.post(REST_SERVICE_URI, game).then(function(response) {
					return response.data;
				}
			);
		}
		
		function updateGameById(id, name, genre)
		{
			
			return $http.put(REST_SERVICE_URI + id + "," + name + "," + genre).then(function(response) {
				return response.data;
				}
			);	
			
		}
		
		function deleteGame(id)
		{
			console.log(id);
			
			
			
			return $http.delete(REST_SERVICE_URI + id).then(function(response) {
					return response.data;
				}
			);
		}
		
		function getGamesByGenre(genre)
		{
			console.log(genre);
			
			return $http.get(REST_SERVICE_URI + "genre/" + genre).then(function(response) {
				return response.data;
				}
			);	
			
		}


}]);
