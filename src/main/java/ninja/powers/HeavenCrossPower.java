package ninja.powers;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.android.mods.AssetLoader;
import ninja.Ninja;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class HeavenCrossPower extends AbstractPower {
    public static final String POWER_ID = "HeavenCrossPower";
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("HeavenCrossPower");
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public HeavenCrossPower(AbstractCreature owner, int amount) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = amount;
        this.updateDescription();
        this.type = PowerType.BUFF;

        String path128 = "img/powers_Ninja/HeavenCrossPower84.png";
        String path48 = "img/powers_Ninja/HeavenCrossPower32.png";
        this.region128 = new TextureAtlas.AtlasRegion( AssetLoader.getTexture(Ninja.MOD_ID,path128), 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion( AssetLoader.getTexture(Ninja.MOD_ID,path48), 0, 0, 32, 32);

        this.updateDescription();
    }

    public void onUseCard(AbstractCard card, UseCardAction action){
        if(card.hasTag(AbstractCard.CardTags.NINJUTSU) || card.cardID == "YiCut"){
            this.addToBot(new ApplyPowerAction(this.owner,this.owner,new LexKela(this.owner,this.amount),this.amount));
        }
    }

    public void updateDescription() {

        this.description = powerStrings.DESCRIPTIONS[0] + this.amount + powerStrings.DESCRIPTIONS[1];


    }
}
