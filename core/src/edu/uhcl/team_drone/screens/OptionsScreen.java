package edu.uhcl.team_drone.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import edu.uhcl.team_drone.assets.Assets;
import edu.uhcl.team_drone.main.Main;

public class OptionsScreen implements Screen{
    
    private Stage stage;

    private Main game;
    
    public OptionsScreen(Main gameIn) {
        this.game = gameIn;
    }

    @Override
    public void show() {
        stage = new Stage(new FitViewport(800,600));
        Gdx.input.setInputProcessor(stage);
        
        TextButton backToMenuButton = new TextButton("Back to Menu", Assets.blueTextBtnStyle);
        
        
        Label label = new Label("OPTIONS", Assets.labelStyle);
        label.setAlignment(Align.center);
        
        Table outerMenuTable = new Table();
        outerMenuTable.setBackground(Assets.backgroundPatch);
        outerMenuTable.setFillParent(true);
        outerMenuTable.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        
        outerMenuTable.add(label).align(Align.center).padBottom(100).size(400, 100);
        outerMenuTable.row();

        outerMenuTable.row();
        outerMenuTable.add(backToMenuButton).size(300, 80).align(Align.center).space(40).padTop(10);
        stage.addActor(outerMenuTable);
        
        backToMenuButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MainMenuScreen(game));
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true); 
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        stage.dispose(); 
    }

}