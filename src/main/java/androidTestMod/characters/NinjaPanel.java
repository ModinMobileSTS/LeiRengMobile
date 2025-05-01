package androidTestMod.characters;

import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.cutscenes.CutscenePanel;

public class NinjaPanel extends CutscenePanel {
    private String sfx;

    public NinjaPanel(String imgUrl, String sfx) {
        super(imgUrl);
        this.sfx = sfx;
    }

    public NinjaPanel(String imgUrl) {
        super(imgUrl);
    }

    public void activate() {
        if (this.sfx != null)
            CardCrawlGame.sound.play(this.sfx);
        this.activated = true;
    }
}
