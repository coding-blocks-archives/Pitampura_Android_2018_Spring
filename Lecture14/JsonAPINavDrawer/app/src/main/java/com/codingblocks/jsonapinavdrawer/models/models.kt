package com.codingblocks.jsonapinavdrawer.models


data class Post(
		var userId: Int?,
		var id: Int?,
		var title: String?,
		var body: String?
)

data class Todo(
		var userId: Int?,
		var id: Int?,
		var title: String?,
		var completed: Boolean?
)

data class Photo(
		var albumId: Int?,
		var id: Int?,
		var title: String?,
		var url: String?,
		var thumbnailUrl: String?
)

data class Album(
		var userId: Int?,
		var id: Int?,
		var title: String?
)
data class User(
		var id: Int?,
		var name: String?,
		var username: String?,
		var email: String?,
		var address: Address?,
		var phone: String?,
		var website: String?,
		var company: Company?
)

data class Address(
		var street: String?,
		var suite: String?,
		var city: String?,
		var zipcode: String?,
		var geo: Geo?
)

data class Geo(
		var lat: String?,
		var lng: String?
)

data class Company(
		var name: String?,
		var catchPhrase: String?,
		var bs: String?
)