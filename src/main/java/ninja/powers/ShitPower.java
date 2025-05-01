package ninja.powers;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.android.mods.AssetLoader;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.android.mods.AssetLoader;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;

public class ShitPower extends AbstractPower {
    public static final String POWER_ID = "ShitPower";
    private static final PowerStrings powerStrings= CardCrawlGame.languagePack.getPowerStrings("ShitPower");
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public ShitPower(AbstractCreature owner, int amount) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = amount ;
        this.updateDescription();
        this.type = PowerType.BUFF;

        String path128 = "img/powers_Ninja/ShitPower84.png";
        String path48 = "img/powers_Ninja/ShitPower32.png";
        this.region128 = new TextureAtlas.AtlasRegion( AssetLoader.getTexture(Ninja.MOD_ID,getResourcePath(path128)), 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion( AssetLoader.getTexture(Ninja.MOD_ID,getResourcePath(path48)), 0, 0, 32, 32);

        this.updateDescription();
    }

    public void atStartOfTurn() {
        this.flash();
        AbstractPower lexkela = AbstractDungeon.player.getPower("LexKela");
        this.addToBot(new ApplyPowerAction(AbstractDungeon.player,AbstractDungeon.player,new LexKela(AbstractDungeon.player,this.amount),this.amount));
        this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, "ShitPower"));
        this.addToBot(new GainEnergyAction(1));
    }


    public void updateDescription() {

        this.description = DESCRIPTIONS[0]+this.amount+DESCRIPTIONS[1];
        this.type = PowerType.BUFF;

    }
}
