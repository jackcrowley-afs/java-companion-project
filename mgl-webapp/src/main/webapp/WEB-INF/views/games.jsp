<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mgl" %>
    <!DOCTYPE html>
    <html>

    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
        <script src="resources/static/js/app.js" /></script>
        <script src="resources/static/js/mglController.js"></script>
        <script src="resources/static/js/mglService.js"></script>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>Mist Library Task 1-Games</title>
        <style type="text/css">
            body {
            	background-image:
            		url('https://ak6.picdn.net/shutterstock/videos/1024598666/thumb/1.jpg');
            	background-repeat: no-repeat;
            	background-size: cover;
            }
        </style>
        <link rel="apple-touch-icon" sizes="180x180" href="/android-chrome-192x192.png">
    	<link rel="icon" type="image/png" sizes="32x32" href="resources/static/images/favicon-32x32.png">
    	<link rel="icon" type="image/png" sizes="16x16" href="resources/static/images/favicon-16x16.png">
    </head>

    <body ng-app="GameApp" class="ng-cloak">
        <mgl:myNav/>
        <br>
        <!-- TODO: mglTaskController has GOT TO GO as a name -->
        <div class="container" ng-controller="mglController as mglTaskController">
            <div class="panel panel-default">
                <div class="panel-heading text-light"><span class="lead">Game Registration Form </span></div>
                <div class="formcontainer">
                    <form ng-submit="mglTaskController.addGame()" name="gameForm" class="form-horizontal">
                        <input type="hidden" ng-model="mglTaskController.game.id" />
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable text-light" for="game_name">Name*</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="mglTaskController.game.name" id="game_name" class="game_name form-control input-sm" placeholder="Enter the name of the new game [required]" required />
                                    <div class="has-error" ng-show="gameForm.$dirty">
                                        <span ng-show="gameForm.game_name.$error.required">This is a required field</span>
                                        <span ng-show="gameForm.game_name.$error.minlength">Minimum length required is 3</span>
                                        <span ng-show="gameForm.game_name.$invalid">This field is invalid </span>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable text-light" for="game_genre">Game Genre</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="mglTaskController.game.genre" id="game_genre" class="form-control input-sm" placeholder="Enter the genre of the new game" />
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-actions floatRight">
                                <input type="submit" value="Add" class="btn btn-primary btn-sm">
                            </div>
                        </div>
                    </form>
                </div>
                
                <div class="row">
                	<div class="form-group col-md-12">
                		<form ng-submit="mglTaskController.getGamesByGenre()" name="gameForm" class="form-horizontal">
                		<label class="col-md-2 control-lable text-light" for="filter_genre">Filter Games By Genre</label>
        			      <div class="col-md-7">
                              <input type="text" ng-model="mglTaskController.filterGenre" id="filter_genre" class="form-control input-sm" placeholder="Enter a Genre to filter." />
                          </div>
                          
                          <br/>
                          
                          	<div class="row">
                            	<div class="form-actions floatRight">
                              		<input type="submit" value="Filter" class="btn btn-primary btn-sm">
                             	</div>
                            </div>
                          </form>
                	</div>
                </div>
                
                <div class="row">
                	<div class = "form-actions floatRight">
                		<form ng-submit="mglTaskController.resetFilter()" name="gameForm" class="form-horizontal">
                			<input type="submit" value="Reset Filter" class="btn btn-primary btn-sm">
                		</form>
                	</div>            
                </div>
                
                
            </div>
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading text-light"><span class="lead">List of all current games</span></div>
                <div class="tablecontainer">
                    <table class="table table-dark table-striped text-light">
                        <thead>
                            <tr>
                                <th>Game Name</th>
                                <th>Game Genre</th>
                                <th width="20%"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr ng-repeat="currentGame in mglTaskController.games">
                                <td><span ng-bind="currentGame.name"></span></td>
                                <td><span ng-bind="currentGame.genre"></span></td>
                                <td>
                                
                                
                                <form ng-submit="mglTaskController.updateGame(currentGame)">
                                	
                                	<input type="submit" value="Update" class="btn btn-primary btn-sm"/>
                                </form>
                                
                                </td>
                                
                                <!--  SEPT-9: Add a Deletion Button Here. -->
                                <td>
                                <form ng-submit="mglTaskController.deleteGame(currentGame)">
                                	
                                	<input type="submit" value="Delete" class="btn btn-primary btn-sm"/>
                                </form>
                                
                                
                                
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </body>
    <script type="text/javascript"></script>

    </html>