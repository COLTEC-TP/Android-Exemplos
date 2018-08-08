package br.ufmg.coltec.tp.exemplorest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import br.ufmg.coltec.tp.exemplorest.models.User;
import br.ufmg.coltec.tp.exemplorest.services.RetrofitConfig;
import br.ufmg.coltec.tp.exemplorest.services.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Evento que fará a busca do usuário
     * @param view
     */
    public void buscarUsuario(View view) {
        final TextView lblUsuario = findViewById(R.id.lbl_usuario);
        EditText txtLogin = findViewById(R.id.txt_login);
        String login = txtLogin.getText().toString();

        RetrofitConfig retrofitConfig = new RetrofitConfig();
        UserService service = retrofitConfig.getUserService();

        Call<User> request = service.getUser(login);

        request.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                // executado quando resposta for recebida
                User user = response.body();

                lblUsuario.setText(user.getBio());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                //executado quando houver erros
                t.printStackTrace();
            }
        });
    }
}
