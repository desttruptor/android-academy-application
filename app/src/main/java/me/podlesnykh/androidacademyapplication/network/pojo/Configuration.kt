package me.podlesnykh.androidacademyapplication.network.pojo

import com.google.gson.annotations.SerializedName

/*
* represents configuration for downloading pictures (base urls, etc)
* */

data class Configuration(

	@field:SerializedName("images")
	val images: Images? = null,
)

data class Images(

	@field:SerializedName("secure_base_url")
	val secureBaseUrl: String? = null,
)
