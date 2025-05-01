package ninja.powers;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.android.mods.AssetLoader;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.WeakPower;

public class DisappointedPower extends AbstractPower {
    public static final String POWER_ID = "DisappointedPower";
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("DisappointedPower");
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public DisappointedPower(AbstractCreature owner) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = -1;
        this.updateDescription();
        this.type = PowerType.DEBUFF;

        String path128 = "img/powers_Ninja/DisappointedPower84.png";
        String path48 = "img/powers_Ninja/DisappointedPower32.png";
        this.region128 = new TextureAtlas.AtlasRegion( AssetLoader.getTexture(Ninja.MOD_ID,getResourcePath(path128)), 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion( AssetLoader.getTexture(Ninja.MOD_ID,getResourcePath(path48)), 0, 0, 32, 32);

        this.updateDescription();
    }

    public void atStartOfTurn(){
        this.flash();
        this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, "DisappointedPower"));
        this.addToBot(new ApplyPowerAction(this.owner , this.owner , new WeakPower(this.owner, 1 , false),1));
    }

    public void updateDescription() {

        this.description = DESCRIPTIONS[0];

    }
}
