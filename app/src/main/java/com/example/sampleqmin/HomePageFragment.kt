package com.example.sampleqmin

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sampleqmin.ApiData.CustomChannelResult
import com.example.sampleqmin.ApiData.FestivalChannelResult
import com.example.sampleqmin.ApiData.GenericChannelResult
import com.example.sampleqmin.databinding.FragmentHomePageBinding
import com.example.sampleqmin.homeadapter.CustomChannelAdapter
import com.example.sampleqmin.homeadapter.FestivalChannelAdapter
import com.example.sampleqmin.homeadapter.GenericChannelAdapter
import com.example.sampleqmin.homeadapter.RestaurantAdapter
import com.example.sampleqmin.homedata.*
import com.google.gson.Gson

class HomePageFragment : Fragment() {

    private lateinit var bind: FragmentHomePageBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = FragmentHomePageBinding.inflate(inflater, container, false)
        return bind.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        apiData()
       // festival()
        restaurants()
        location()
    }

//    private fun genericChannel() {
//        val genericData = GenericChannelData(
//            listOf(
//                GenericItem("EveryDay Easy", "Popular Easy"),
//                GenericItem("Comfort", "EveryDay comfort food"),
//                GenericItem("Family Fest", "Multi-Cuisine menus"),
//                GenericItem("Signature", "Biryani qlub & one box meat"),
//                GenericItem("Q-Kids", "What's food without some fun?"),
//            )
//        )
//        bind.rvGenericChannel.adapter = GenericChannelAdapter(genericData.data)
//        bind.rvGenericChannel.layoutManager =
//            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//
//    }

   /* private fun customChannel() {
        val customData = CustomChannelData(
            listOf(
                CustomItem("Qmin Celebration", "One stop shop for all your virtual celebration"),
                CustomItem("Hampers", "Exclusive bundles of delight")
            )
        )
        bind.rvCustomChannel.adapter = CustomChannelAdapter(customData.data)
        bind.rvCustomChannel.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }*/

//    private fun festival() {
//        val festivalData = FestivalChannelData(
//            listOf(
//                FestivalItem("Holi"),
//                FestivalItem("Meat.ish")
//            )
//        )
//        bind.rvFestivals.adapter = FestivalChannelAdapter(festivalData.data)
//        bind.rvFestivals.layoutManager =
//            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//    }

    private fun restaurants() {
        val restaurantData = listOf(
            RestaurantData(
                "Taj SATS,Chennai",
                listOf(
                    Hotels("ANUKA", "Multi-cuisine"),
                    Hotels("Ultimate Indian Street Food", "Meals for all"),
                    Hotels("Q-Kids", "ulti-cuisine"),
                    Hotels("Signature", "Qmin-Signature")
                ),
            ),
            RestaurantData(
                "Vivanta Chennai,IT Expressway",
                listOf(
                    Hotels("Mynt", "Multi-cuisine"),
                    Hotels("Qmin Comfort", "Multi-cuisine"),
                    Hotels("Q-Kids", "Multi-cuisine"),
                    Hotels("Signature", "Qmin Signature"),
                    Hotels("Family Fest", "Everyday Meals for Family")
                )
            )
        )
        bind.rvRes.adapter = RestaurantAdapter(restaurantData)
        bind.rvRes.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)


    }

    private fun apiData(){
        val api   ="{\n" +
                "  \"statusCode\": 200,\n" +
                "  \"message\": \"Successfully fetched the channels\",\n" +
                "  \"result\": {\n" +
                "    \"is_outside_visible\": false,\n" +
                "    \"generic_channels\": [\n" +
                "      {\n" +
                "        \"name\": \"Q-Kids\",\n" +
                "        \"id\": \"cfd381e4-be54-4e6e-af07-528d6fac6c09\",\n" +
                "        \"image_url\": \"https://tatadigital-prod-cdn.adobecqms.net/content/dam/ihcl-fine-dine-app/default/discovery/Kids-discovery-section-image.jpg/jcr:content/renditions/cq5dam.web.640.640.png\",\n" +
                "        \"created_at\": \"2020-12-10T15:37:55.7Z\",\n" +
                "        \"header_text\": \"Qmin Kids\",\n" +
                "        \"body_hero_text\": \"Kids Special Menu\",\n" +
                "        \"body_description\": \"An all-things Kids menu curated for those little eyes to light up. Fun-filled meals, tasty bites and delicious treats filled with exciting ingredients with a colourful twist. All-time favourites like jalapeno poppers, nuggets, burgers, chocolate brownies and more that kids will love. Let the fun begin!\",\n" +
                "        \"query_attribute\": \"qmin_kids\",\n" +
                "        \"icon_url\": null,\n" +
                "        \"restaurant_id\": null,\n" +
                "        \"static_content_url\": \"base_url?catgory=qmin_kids\",\n" +
                "        \"channel_description\":\"Lorem lipsum lorem lipsum\",\n" +
                "        \"is_new\": false,\n" +
                "        \"type\": \"generic\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Family Feast\",\n" +
                "        \"id\": \"e98b91f8-5978-4969-93e5-33d87a9dc4fa\",\n" +
                "        \"image_url\": \"https://tatadigital-prod-cdn.adobecqms.net/content/dam/ihcl-fine-dine-app/festive/family-feast/Qmin_Platter_Banner_326-90-px.jpg/jcr:content/renditions/cq5dam.web.640.640.png\",\n" +
                "        \"created_at\": \"2020-12-10T15:37:55.7Z\",\n" +
                "        \"header_text\": \"Family Feast\",\n" +
                "        \"body_hero_text\": \"Family Meals\",\n" +
                "        \"body_description\": \"Family Meals\",\n" +
                "        \"query_attribute\": \"Q_family\",\n" +
                "        \"icon_url\": null,\n" +
                "        \"restaurant_id\": \"973c2f0b-e194-4c08-889c-85c8ee8d3241\",\n" +
                "        \"static_content_url\": \"base_url?catgory=Q_family\",\n" +
                "        \"channel_description\":\"Family feast for family time\",\n" +
                "        \"is_new\": false,\n" +
                "        \"type\": \"generic\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Signature\",\n" +
                "        \"id\": \"21caa2b8-0294-4ecf-b8ad-82e6c3dbf357\",\n" +
                "        \"image_url\": \"https://tatadigital-prod.adobecqms.net/content/dam/ihcl-fine-dine-app/festive/dawaat-e-khaas/Banner2.png/jcr:content/renditions/cq5dam.web.640.640.png\",\n" +
                "        \"created_at\": \"2020-12-10T15:37:55.7Z\",\n" +
                "        \"header_text\": \"Signatures\",\n" +
                "        \"body_hero_text\": \"Meals for all\",\n" +
                "        \"body_description\": \"One Box Meals and Biryani Platters\",\n" +
                "        \"query_attribute\": \"Q_Signature\",\n" +
                "        \"icon_url\": null,\n" +
                "        \"restaurant_id\": \"28a8701d-ca3e-42b3-9ef9-01c8a7728728\",\n" +
                "        \"static_content_url\": \"base_url?catgory=Q_Signature\",\n" +
                "        \"channel_description\":\"Lorem lipsum lorem lipsum\",\n" +
                "        \"is_new\": false,\n" +
                "        \"type\": \"generic\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Patisserie\",\n" +
                "        \"id\": \"519accaa-25fe-4259-91a9-cb0073dd9a15\",\n" +
                "        \"image_url\": \"https://tatadigital-prod-cdn.adobecqms.net/content/dam/ihcl-fine-dine-app/default/la-patisserie/Qmin_La-Patisserie_640-PX.jpg/jcr:content/renditions/cq5dam.web.640.640.png\",\n" +
                "        \"created_at\": \"2020-12-10T15:37:55.7Z\",\n" +
                "        \"header_text\": \"Patisserie\",\n" +
                "        \"body_hero_text\": \"Patisserie\",\n" +
                "        \"body_description\": \"Cake shop and delicatessen, offers delicious desserts, & freshly baked breads and savoury treat\",\n" +
                "        \"query_attribute\": \"la_patisserie\",\n" +
                "        \"icon_url\": null,\n" +
                "        \"restaurant_id\": null,\n" +
                "        \"static_content_url\": \"base_url?catgory=la_patisserie\",\n" +
                "        \"channel_description\":\"Lorem lipsum lorem lipsum\",\n" +
                "        \"is_new\": false,\n" +
                "        \"type\": \"generic\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Comfort\",\n" +
                "        \"id\": \"b42621ad-a75d-4e86-bee1-cb466e2a1d76\",\n" +
                "        \"image_url\": \"https://tatadigital-prod-cdn.adobecqms.net/content/dam/ihcl-fine-dine-app/default/discovery/Comfort-discovery-section-image.jpg/jcr:content/renditions/cq5dam.web.640.640.png\",\n" +
                "        \"created_at\": \"2020-12-10T15:37:55.7Z\",\n" +
                "        \"header_text\": \"Qmin Comfort\",\n" +
                "        \"body_hero_text\": \"Happiness Delivered\",\n" +
                "        \"body_description\": \"Soulful Combo Meals, Nostalgic Flavours, Sweet Cravings. All-of-your-favourite comfort food, just a click away as you smile away your every mood. With Qmin, every day let comfort come home.\",\n" +
                "        \"query_attribute\": \"qmin_comfort\",\n" +
                "        \"icon_url\": null,\n" +
                "        \"restaurant_id\": null,\n" +
                "        \"static_content_url\": \"base_url?catgory=qmin_comfort\",\n" +
                "        \"channel_description\":\"Lorem lipsum lorem lipsum\",\n" +
                "        \"is_new\": false,\n" +
                "        \"type\": \"generic\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Innergise\",\n" +
                "        \"id\": \"42c864e3-93b6-4d6b-972d-8cea4b3f218b\",\n" +
                "        \"image_url\": \"https://tatadigital-prod-cdn.adobecqms.net/content/dam/ihcl-fine-dine-app/festive/16.jpg/jcr:content/renditions/cq5dam.web.640.640.png\",\n" +
                "        \"created_at\": \"2020-12-10T15:37:55.7Z\",\n" +
                "        \"header_text\": \"Innergise\",\n" +
                "        \"body_hero_text\": \"Nourish and Relish\",\n" +
                "        \"body_description\": \"A special menu packed with anti-oxidants and immunity-boosting superfoods. Featuring healthy dishes like Ragi Uttapams, Amchoori Kale Chane, Quinoa Methi Tikki to Gond Ke Ladoo and Rabdi aur Sabja, make for wholesome nutritious meals. Reconnect with your roots and Innergise with soulful & authentic flavours delivered at the comfort of your home.\",\n" +
                "        \"query_attribute\": \"la_pat\",\n" +
                "        \"icon_url\": null,\n" +
                "        \"restaurant_id\": null,\n" +
                "        \"static_content_url\": \"base_url?catgory=la_pat\",\n" +
                "        \"channel_description\":\"Lorem lipsum lorem lipsum\",\n" +
                "        \"is_new\": false,\n" +
                "        \"type\": \"generic\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"custom_channels\": [\n" +
                "      {\n" +
                "        \"name\": \"Celebrations\",\n" +
                "        \"id\": \"e0c80c29-532d-4a9f-b597-4a368b4c1778\",\n" +
                "        \"image_url\": \"https://tatadigital-prod-cdn.adobecqms.net/content/dam/ihcl-fine-dine-app/default/discovery/Comfort-discover-section-image.jpg/jcr:content/renditions/cq5dam.web.640.640.png\",\n" +
                "        \"created_at\": \"2020-12-10T15:37:55.7Z\",\n" +
                "        \"header_text\": \"\",\n" +
                "        \"body_hero_text\": \"\",\n" +
                "        \"body_description\": \"\",\n" +
                "        \"query_attribute\": \"qmin_celebrations\",\n" +
                "        \"icon_url\": null,\n" +
                "        \"restaurant_id\": null,\n" +
                "        \"static_content_url\": \"base_url?catgory=qmin_celebrations\",\n" +
                "        \"channel_description\":\"Lorem lipsum lorem lipsum\",\n" +
                "        \"is_new\": false,\n" +
                "        \"type\": \"custom\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Hampers\",\n" +
                "        \"id\": \"45058e01-8475-461f-8c69-704442e73933\",\n" +
                "        \"image_url\": \"https://tatadigital-prod-cdn.adobecqms.net/content/dam/ihcl-fine-dine-app/festive/family-feast/Qmin_Platter_Banner_640-px.jpg/jcr:content/renditions/cq5dam.web.640.640.png\",\n" +
                "        \"created_at\": \"2021-12-01T15:37:55.7Z\",\n" +
                "        \"header_text\": \"\",\n" +
                "        \"body_hero_text\": \"\",\n" +
                "        \"body_description\": \"\",\n" +
                "        \"query_attribute\": \"qmin_hampers\",\n" +
                "        \"icon_url\": null,\n" +
                "        \"restaurant_id\": \"27b89ad5-7368-47d0-8eb8-ce5dd255b9ce\",\n" +
                "        \"static_content_url\": \"base_url?catgory=qmin_hampers\",\n" +
                "        \"channel_description\":\"Lorem lipsum lorem lipsum\",\n" +
                "        \"is_new\": true,\n" +
                "        \"type\": \"custom\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"is_encrypted\": false\n" +
                "}"
        val genericGson = Gson().fromJson(api,GenericChannelResult::class.java)
        bind.rvGenericChannel.adapter = GenericChannelAdapter(genericGson.result.generic_channels)

        val customGson = Gson().fromJson(api,CustomChannelResult::class.java)
        bind.rvCustomChannel.adapter = CustomChannelAdapter(customGson.result.custom_channels)

        val festivalGson = Gson().fromJson(api,FestivalChannelResult::class.java)
        bind.rvFestivals.adapter = FestivalChannelAdapter(festivalGson.result.generic_channels)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun location() {
        val locationPermissionRequest =
            registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
                when {
                    permissions.getOrDefault(
                        android.Manifest.permission.ACCESS_FINE_LOCATION,
                        false
                    ) -> {

                    }
                    permissions.getOrDefault(
                        android.Manifest.permission.ACCESS_COARSE_LOCATION,
                        false
                    ) -> {

                    }
                    else -> {

                    }
                }
            }
        locationPermissionRequest.launch(
            arrayOf(
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }
}

