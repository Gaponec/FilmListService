var app = angular.module("filmApp",[]);

app.controller("filmCTRL", function ($scope,$http) {
    $scope.films="";

    $http.get('http://localhost:8080/getFilms').then(function (responce) {
        $scope.films = responce.data;
        console.log(responce.data.Title);
    });
})