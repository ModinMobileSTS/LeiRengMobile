package androidTestMod.relics;

import androidTestMod.powers.SciencePower;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomRelic;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class Salt extends CustomRelic {
    public static final String ID = "Salt";
    private static final String IMG = "img/relics_Ninja/Salt.png";
    private static final String IMG_OTL = "img/relics_Ninja/outline/Salt.png";
    private boolean activated = true;

    //调用父类的构造方法，传参为super(遗物ID,遗物全图，遗物白底图，遗物稀有度，获得遗物时的音效)
    public Salt() {
        super(ID, ImageMaster.loadImage(IMG), ImageMaster.loadImage(IMG_OTL), RelicTier.SHOP, LandingSound.FLAT);
    }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }


    public void atTurnStart() {
        if (AbstractDungeon.player.getPower("SciencePower") == null){
            this.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
            this.flash();
            CardCrawlGame.sound.play("Salt");
            this.addToBot(new ApplyPowerAction(AbstractDungeon.player,AbstractDungeon.player,new SciencePower(AbstractDungeon.player,1),1));
        }

        this.activated = true;
    }

    public boolean checkTrigger() {
        return this.activated;
    }

    public AbstractRelic makeCopy(){
        return new Salt();
    }
}
