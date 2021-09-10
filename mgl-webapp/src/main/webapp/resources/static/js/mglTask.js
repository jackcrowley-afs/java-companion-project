'use strict';

angular.module('GameApp').factory('mglService', ['$http', function($http) {

		var REST_SERVICE_URI = 'game/';

		var factory = {
			fetchAllGames : fetchAllGames,
			createGame : createGame
		};

		return factory;

		function fetchAllGames() {
			return $http.get(REST_SERVICE_URI + '').then(function(response) {
					return response.data;
				}
			);
		}

		function createGame(game) {
			return $http.post(REST_SERVICE_URI + '', game).then(function(response) {
					return response.data;
				}
			);
		}

}]);
