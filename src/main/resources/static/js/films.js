var app = angular.module("filmApp",[]);

app.controller("filmsCTRL", function ($scope,$http) {
    $scope.films=[];

    $http.get('http://localhost:8080/getFilms').then(function (responce) {

        $scope.films= responce.data;

        console.log($scope.films);
    });
});

app.controller("filmCTRL", function ($scope,$http) {

    var link = 'http://localhost:8080/getFilm';

    $http.get(link,{
        params:{title: title}
    }).then(function (responce) {
        $scope.film = responce.data.film;

        console.log($scope.film);
    });
});

$(function () {
    $("#includeHeader").load("elements/header.html");
});