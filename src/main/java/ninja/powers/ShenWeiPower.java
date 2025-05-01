package ninja.powers;

import ninja.actions.ShenWeiAction;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.android.mods.AssetLoader;
import ninja.Ninja;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class ShenWeiPower extends AbstractPower {
    public static final String POWER_ID = "ShenWeiPower";
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("ShenWeiPower");
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public ShenWeiPower(AbstractCreature owner) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = -1;
        this.updateDescription();
        this.type = PowerType.BUFF;

        String path128 = "img/powers_Ninja/ShenWeiPower84.png";
        String path48 = "img/powers_Ninja/ShenWeiPower32.png";
        this.region128 = new TextureAtlas.AtlasRegion( AssetLoader.getTexture(Ninja.MOD_ID,path128), 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion( AssetLoader.getTexture(Ninja.MOD_ID,path48), 0, 0, 32, 32);

        this.updateDescription();
    }

    public void atStartOfTurn(){
        this.flash();
        this.addToBot(new ShenWeiAction());
    }

    public void onUseCard(AbstractCard card, UseCardAction action){
        if(card.type == AbstractCard.CardType.ATTACK){
            AbstractPower intangible = this.owner.getPower("IntangiblePlayer");
            this.flash();
            if (this.amount == 0) {
                this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, "IntangiblePlayer"));
            } else {
                this.addToBot(new ReducePowerAction(this.owner, this.owner, "IntangiblePlayer", 1));
            }
        }
    }

    public void updateDescription() {

        this.description = powerStrings.DESCRIPTIONS[0];


    }
}
