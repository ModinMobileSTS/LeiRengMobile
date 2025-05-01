package androidTestMod.powers;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class SandWall extends AbstractPower {
    public static final String POWER_ID = "SandWall";
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("SandWall");
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public SandWall(AbstractCreature owner, int amount) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = amount;
        this.updateDescription();
        this.type = PowerType.BUFF;

        String path128 = "img/powers_Ninja/SandWall84.png";
        String path48 = "img/powers_Ninja/SandWall32.png";
        this.region128 = new TextureAtlas.AtlasRegion(ImageMaster.loadImage(path128), 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion(ImageMaster.loadImage(path48), 0, 0, 32, 32);
    }

    public void updateDescription() {

        this.description = powerStrings.DESCRIPTIONS[0] + this.amount + powerStrings.DESCRIPTIONS[1];

    }

    public void atStartOfTurn(){

        this.flash();
        this.addToBot(new GainBlockAction(this.owner,this.amount));
        if(this.amount != 0 && this.owner.hasPower("BuildSandWallPower")){
            this.addToBot(new ApplyPowerAction(this.owner,this.owner,new SandWall(this.owner,-1),-1));
        }
        else {
            this.addToBot(new ApplyPowerAction(this.owner,this.owner,new SandWall(this.owner,-this.amount/2),-this.amount/2));
        }
        if(this.amount<=1){
            addToBot(new RemoveSpecificPowerAction(this.owner,this.owner,"SandWall"));
        }
    }
}
