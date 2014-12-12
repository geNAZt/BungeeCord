package net.md_5.bungee.api;

import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Fabian on 12.12.14.
 */
public class AnimatedServerPing extends ServerPing
{
    @Data
    public class AnimationFrame
    {
        private ServerPing ping;
        private long stayTime;
    }

    private List<AnimationFrame> animationFrames = new ArrayList<>();
    private Iterator<AnimationFrame> iterator;

    public void addFrame(AnimationFrame animationFrame)
    {
        animationFrames.add(animationFrame);
    }

    public void removeFrame(AnimationFrame animationFrame)
    {
        animationFrames.remove(animationFrame);
    }

    public Iterator<AnimationFrame> getIterator()
    {
        if (iterator == null)
        {
            iterator = animationFrames.iterator();
        }

        return iterator;
    }

    public long getCompleteAnimationTime()
    {
        long animationTime = 0;

        for (AnimationFrame animationFrame : animationFrames)
        {
            animationTime += animationFrame.getStayTime();
        }

        return animationTime;
    }
}
