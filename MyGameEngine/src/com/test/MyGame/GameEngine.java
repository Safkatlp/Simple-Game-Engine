package com.test.MyGame;

public class GameEngine implements Runnable{

	private Thread thread;
	private boolean running = false;
	private final double UPDATE_INTERVAL ; // update rate or time between every update


	public GameEngine(double fps)
	{
		UPDATE_INTERVAL = 1.0d/fps;
		start();// will be change later
	}

	public void start() 
	{
		thread = new Thread(this);
		thread.run();
	}

	public void stop()
	{

	}

	public void run() 
	{
		running = true;

		double firstTime = 0;
		double lastTime = System.nanoTime() / 1000000000.0; 
		double passedTime = 0;
		double timeGap = 0; // time gap between every update
		boolean render ;

		double frameTime = 0;
		int frames = 0;
		int fps = 0;

		while(running) 
		{
			firstTime = System.nanoTime() / 1000000000.0;
			passedTime = (firstTime - lastTime);
			lastTime = firstTime;

			timeGap += passedTime;
			frameTime += passedTime;
			
			render = false;
			
			while(timeGap >= UPDATE_INTERVAL)
			{
				timeGap -= UPDATE_INTERVAL; 
				render = true;
				//TODO: update();
				
				if(frameTime >= 1.0)
				{
					//System.out.println("Frame time: "+frameTime);
					frameTime = 0;
					fps = frames;
					frames = 0;
					System.out.println("FPS: "+fps);
				}
				//end of inner while
			}

			if(render) 
			{
				//TODO: render();
				frames++;
			}
			else
			{
				try
				{
					Thread.sleep(1);
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			
			//end of outer while
		}
		
		dispose();
	}

	private void dispose()
	{

	}
}
