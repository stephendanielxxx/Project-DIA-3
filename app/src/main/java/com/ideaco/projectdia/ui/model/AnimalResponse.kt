package com.ideaco.projectdia.ui.model

import com.google.gson.annotations.SerializedName

/*
{
	"name": "Barred Owl",
	"latin_name": "Strix varia",
	"animal_type": "Bird",
	"active_time": "Nocturnal",
	"length_min": "1.4",
	"length_max": "1.6",
	"weight_min": "1",
	"weight_max": "2.3",
	"lifespan": "20",
	"habitat": "Forest",
	"diet": "Small mammals",
	"geo_range": "North America",
	"image_link": "https://upload.wikimedia.org/wikipedia/commons/3/3c/Strix-varia-005.jpg",
	"id": 26
}
 */
data class AnimalResponse(
    var name: String,
    @SerializedName("latin_name")
    var latinName: String,
    @SerializedName("animal_type")
    var animalType: String,
    @SerializedName("active_time")
    var activeTime: String,
    @SerializedName("length_min")
    var lengthMin: String,
    @SerializedName("length_max")
    var lengthMax: String,
    @SerializedName("weight_min")
    var weightMin: String,
    @SerializedName("weight_max")
    var weightMax: String,
    @SerializedName("lifespan")
    var lifespan: String,
    @SerializedName("habitat")
    var habitat: String,
    @SerializedName("diet")
    var diet: String,
    @SerializedName("geo_range")
    var geoRange: String,
    @SerializedName("image_link")
    var imageLink: String,
    @SerializedName("id")
    var id: String,
)
