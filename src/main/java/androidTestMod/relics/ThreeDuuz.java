package androidTestMod.relics;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomRelic;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class ThreeDuuz extends CustomRelic {
    public static final String ID = "ThreeDuuz";
    private static final String IMG = "img/relics_Ninja/3Duuz.png";
    private static final String IMG_OTL = "img/relics_Ninja/outline/3Duuz.png";
    private static final int AMOUNT = 3;
    private boolean activated = true;

    public ThreeDuuz() {
        super(ID, ImageMaster.loadImage(IMG), ImageMaster.loadImage(IMG_OTL), RelicTier.BOSS, LandingSound.MAGICAL);
    }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0] ;
    }

    public void atTurnStart() {
        this.activated = true;
    }

    public boolean checkTrigger() {
        return this.activated;
    }

    public void onUseCard(AbstractCard card, UseCardAction action) {
        if (card.hasTag(CardTags.NINJUTSU) && this.activated){
            this.activated = false;
            CardCrawlGame.sound.play("3Duuz");
            this.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
            this.flash();
            this.addToTop(new DrawCardAction(2));
            this.pulse = false;
        }

    }

    public AbstractRelic makeCopy() {
        return new ThreeDuuz();
    }
}
