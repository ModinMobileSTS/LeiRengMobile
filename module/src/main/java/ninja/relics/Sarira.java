package ninja.relics;

import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomRelic;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

import ninja.cards.SariraRevive;

public class Sarira extends CustomRelic /*implements OnPlayerDeathRelic*/ {
    public static final String ID = "Sarira";
    private static final String IMG = "img/relics_Ninja/Sarira.png";
    private static final String IMG_OTL = "img/relics_Ninja/outline/Sarira.png";
    public boolean triggered;

    public Sarira() {
        super(ID, ImageMaster.loadImage(IMG), ImageMaster.loadImage(IMG_OTL), AbstractRelic.RelicTier.SPECIAL, AbstractRelic.LandingSound.MAGICAL);
        this.triggered = false;
        this.grayscale = false;
    }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

    public boolean onPlayerDeath(AbstractPlayer abstractPlayer, DamageInfo damageInfo) {
        if (!this.triggered) {
            AbstractPlayer p = AbstractDungeon.player;
            p.isDying = false;
            p.isDead = false;
            AbstractDungeon.getCurrRoom().phase = AbstractRoom.RoomPhase.COMBAT;
            p.currentHealth = 1;
            CardCrawlGame.sound.play(SariraRevive.ID);
            addToTop(new RelicAboveCreatureAction(p, this));
            addToTop(new HealAction(p, p, p.maxHealth));
            this.triggered = true;
            this.grayscale = true;
            return false;
        }
        return true;
    }

    public AbstractRelic makeCopy() {
        return new Sarira();
    }
}