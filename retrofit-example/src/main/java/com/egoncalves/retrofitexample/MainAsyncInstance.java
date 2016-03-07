package com.egoncalves.retrofitexample;

import com.egoncalves.retrofitexample.model.User;
import com.egoncalves.retrofitexample.services.MyApiEndpointInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainAsyncInstance {
	// Trailing slash is needed
	public static final String BASE_URL = "https://api.github.com/";

	public static void main(String[] args) {
		System.out.println("Chamada Assincrona...");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();

		Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create(gson)).build();

		MyApiEndpointInterface apiService = retrofit.create(MyApiEndpointInterface.class);
		String username = "esmaelgoncalves";
		Call<User> call = apiService.getUser(username);

		//Empilha a chamada numa nova thread.
		call.enqueue(new Callback<User>() {
			@Override
			public void onResponse(Call<User> call, Response<User> response) {
				int statusCode = response.code();
				User user = response.body();

				System.out.println("Status: " + statusCode);
				System.out.println("Usuário: " + user);
				
			}

			@Override
			public void onFailure(Call<User> call, Throwable t) {
				System.err.println(t);
			}
		});
		
		System.out.println("A Thread continua executando...");
		
	}
}
