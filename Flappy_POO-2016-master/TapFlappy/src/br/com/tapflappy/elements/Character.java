package br.com.tapflappy.elements;

import com.br.tapflappy.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import br.com.tapflappy.engine.Sound;
import br.com.tapflappy.graphic.Colors;
import br.com.tapflappy.graphic.Screen;

public class Character {
	
	public static final float L_RECT = 100;
	public static final float R_RECT = 150;
	public static final  float RADIUS = 50;
	private float height;
	public float base;
	
	private Screen screen;
	private Sound sound;
	private Bitmap character;
	
	private static final Paint CHAR_COLOR = Colors.getColorOfCharacter();
	public static final float X = 100;
	
	
	public Character(Screen screen, Sound sound, Context context){
		
		this.screen = screen;
		this.sound = sound;
		this.base = 150;
		this.height = 100;
		Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.character);
		this.character = Bitmap.createScaledBitmap(bp, (int)RADIUS*2, (int)RADIUS*2, false);
	}

	public void drawOnThe(Canvas canvas){
		//canvas.drawCircle(L_RECT, height, RADIUS, CHAR_COLOR);
		//canvas.drawRect(L_RECT, height, R_RECT , base, CHAR_COLOR);
		canvas.drawBitmap(character, X - RADIUS, height - RADIUS, null);
		
	}

	public void drop() {
		
		boolean floor = base > screen.getHeight();
		
		if(!floor) {
			this.height += 5;                                                                             
			this.base += 5;
		}
		
	}

	public void jump() {
		if(height > 0){
			this.height -= 100;
			this.base -= 100;
			
			sound.play(Sound.PULO);
			//PULO é static, portanto acessado através diretamente da classe
		}
		
	}

	public float getHeight() {
		return this.height;
	}
}
