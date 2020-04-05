var app = angular.module("ToDoApp", []);
app.controller("ToDoCtrl", function($scope, $http) {
	$scope.message = "";
	$scope.visibleStatus = "ALL";
	$scope.todoDesc = "";
	$scope.todoList = [];

	$scope.showList = function() {
		$http.get('/todos?isCompleted='+$scope.visibleStatus).then(function(respJson) {
			console.log(respJson.data);
			$scope.todoList = respJson.data;
		});
	};
	$scope.add = function() {
		console.log($scope.todeDesc);
		$http.post('/todos/'+$scope.todoDesc).then(function(respJson) {
			$scope.message = respJson;
			console.log(''+respJson);
			$scope.todoList.push(respJson.data);
		});
	};
	$scope.delete = function(todoItem) {
		console.log("Delete todoItem: "+todoItem);
		$http.delete('/todos/'+todoItem.id).then(function() {
			$scope.showList();
		});
	};
	$scope.complete = function(todoItem) {
		console.log("Completed todoItem: "+todoItem);
		$http.put('/todos/'+todoItem.id + '?isCompleted=true').then(function(respJson) {
			$scope.showList();
		});
	};
	$scope.pending = function(todoItem) {
		console.log("Completed todoItem: "+todoItem);
		$http.put('/todos/'+todoItem.id + '?isCompleted=false').then(function(respJson) {
			$scope.showList();
		});
	};
});