package com.egoncalves.retrofitexample;

import java.io.IOException;

import com.egoncalves.retrofitexample.interfaces.MyApiEndpointInterface;
import com.egoncalves.retrofitexample.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainSyncInstance {
	// Trailing slash is needed
	public static final String BASE_URL = "https://api.github.com/";

	public static void main(String[] args) {

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();

		Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create(gson)).build();

		MyApiEndpointInterface apiService = retrofit.create(MyApiEndpointInterface.class);
		String username = "esmaelgoncalves";
		Call<User> call = apiService.getUser(username);

		try {
			System.out.println("Chamada Sincrona...");
			Response<User> response = call.execute();

			User user = response.body();
			int code = response.code();
			
			System.out.println("Status: " + code);
			System.out.println("Usuário: " + user);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
