package ninja.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.core.CardCrawlGame;

public class PlaySoundAction extends AbstractGameAction {
    private String key;

    public PlaySoundAction(String key){
        this.key = key;
    }

    public void update(){
        CardCrawlGame.sound.play(this.key);
        this.isDone = true;
    }

}
