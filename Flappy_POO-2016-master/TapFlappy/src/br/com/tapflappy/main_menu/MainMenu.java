package br.com.tapflappy.main_menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import br.com.tapflappy.MainActivity;
import com.br.tapflappy.*;

import android.app.Activity;

public class MainMenu extends Activity {


	private Button playButon;
	private Button quitButton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_menu);
        
        playButon = (Button) findViewById(R.id.PLAY);
        quitButton = (Button) findViewById(R.id.QUIT);
          
    	playButon.setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent fase1scr = new Intent(MainMenu.this/*v.getContext()getApplicationContext()*/, MainActivity.class);
				startActivity(fase1scr);
			};
		});
    	
    	quitButton.setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				/* Aqui sai do jogo; */
				
				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
				
			}
		});
    
    }
}
