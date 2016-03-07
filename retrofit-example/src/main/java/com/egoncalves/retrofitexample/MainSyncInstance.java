package com.egoncalves.retrofitexample;

import java.io.IOException;
import java.util.List;

import com.egoncalves.retrofitexample.model.User;
import com.egoncalves.retrofitexample.services.MyApiEndpointInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainSyncInstance {
	// Trailing slash is needed
	public static final String BASE_URL = "https://api.github.com/";
	
	static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();

	static Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
			.addConverterFactory(GsonConverterFactory.create(gson)).build();

	static MyApiEndpointInterface apiService = retrofit.create(MyApiEndpointInterface.class);

	public static void main(String[] args) {

		String username = "esmaelgoncalves";
		
		getUser(username);
		
		getUsers();
		
	}

	private static void getUser(String username) {
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
	
	private static void getUsers() {
		Call<List<User>> call = apiService.getUsers();
		try {
			System.out.println("Chamada Sincrona...");
			Response<List<User>> response = call.execute();

			List<User> users = response.body();
			int code = response.code();
			
			System.out.println("Status: " + code);
			System.out.println("Usuários: ");
			
			for (User user : users) {
				System.out.println(user);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
