package br.ufmg.coltec.tp.exemplorest.services;

import br.ufmg.coltec.tp.exemplorest.models.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {

    @GET("users/{login}")
    public Call<User> getUser(@Path("login") String login);

}
