package edu.uhcl.team_drone.main;

import edu.uhcl.team_drone.input.hardware.DroneDriver;
import edu.uhcl.team_drone.assets.Assets;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import edu.uhcl.team_drone.screens.DebugScreen;

public class Main extends Game {

    public static PerspectiveCamera cam; // 3D camera
    public static ModelBatch modelBatch; // used to render the instance    

    @Override
    public void create() {
        Assets.init();       

        modelBatch = new ModelBatch();        
       
        cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());        
        cam.near = 400f;
        cam.far = 25000f;        
        cam.update(true);       
                
        setScreen(new DebugScreen(this));        
    }

    @Override
    public void render() {
        super.render();
    } 

}
