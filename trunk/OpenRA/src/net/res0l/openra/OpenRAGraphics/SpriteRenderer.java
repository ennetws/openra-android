package net.res0l.openra.OpenRAGraphics;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import net.res0l.openra.OpenRAFileFormat.Vertex;
import net.res0l.openra.OpenRAFileFormat.IGraphicsDevice.*;

public class SpriteRenderer implements Renderer.IBatchRenderer
{
	Renderer renderer;
	IShader shader;

	Vertex[] vertices = new Vertex[Renderer.TempBufferSize];
	long[] indices = new long[Renderer.TempBufferSize];
	int nv = 0, ni = 0;

	public SpriteRenderer(Renderer renderer, IShader shader)
	{
		this.renderer = renderer;
		this.shader = shader;
	}
			
	public void DrawSprite(Sprite s, Vector2 location, WorldRenderer wr, String palette)
	{
		Rectangle size = s.getBoundingRectangle();
		
		DrawSprite(s, location, wr.GetPaletteIndex(palette), new Vector2(size.getWidth(), size.getHeight()));
	}
	
	public void DrawSprite(Sprite s, Vector2 location, WorldRenderer wr, String palette, Rectangle size)
	{
		DrawSprite(s, location, wr.GetPaletteIndex(palette), new Vector2(size.getWidth(), size.getHeight()));
	}
	
	public void DrawSprite(Sprite s, Vector2 location, int paletteIndex, Vector2 size)
	{
		Renderer.batch.begin();
		s.draw(Renderer.batch);
		Renderer.batch.end();
	}
	
	// For RGBASpriteRenderer, which doesn't use palettes
	public void DrawSprite(Sprite s, Vector2 location)
	{
		Rectangle size = s.getBoundingRectangle();
		
		DrawSprite(s, location, 0, new Vector2(size.getWidth(), size.getHeight()));
	}
	
	public void DrawSprite(Sprite s, Vector2 location, Vector2 size)
	{
		DrawSprite(s, location, 0, size);
	}

	public void Flush() {

	}
}
