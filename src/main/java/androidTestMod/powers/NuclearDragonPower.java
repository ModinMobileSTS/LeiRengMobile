package androidTestMod.powers;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.vfx.combat.ScreenOnFireEffect;

public class NuclearDragonPower extends AbstractPower {

    public static final String POWER_ID = "NuclearDragonPower";
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("NuclearDragonPower");
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    public AbstractPlayer p;
    public int magicNumber;
    public int block;

    public NuclearDragonPower(AbstractCreature owner,int amount) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = amount;
        this.updateDescription();
        this.type = PowerType.BUFF;

        String path128 = "img/powers_Ninja/NuclearDragonPower84.png";
        String path48 = "img/powers_Ninja/NuclearDragonPower32.png";
        this.region128 = new TextureAtlas.AtlasRegion(ImageMaster.loadImage(path128), 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion(ImageMaster.loadImage(path48), 0, 0, 32, 32);

    }

    public void updateDescription() {

        this.description = DESCRIPTIONS[0]+this.amount+DESCRIPTIONS[1];
        this.type = PowerType.BUFF;

    }

    public void atEndOfTurn(boolean isPlayer) {
        AbstractPower lexkela = this.owner.getPower("LexKela");
        if (lexkela != null && lexkela.amount > 0) {
            CardCrawlGame.sound.play("NuclearDragon");
            this.addToBot(new ApplyPowerAction(AbstractDungeon.player , AbstractDungeon.player ,new StrengthPower(AbstractDungeon.player,1)));
            AbstractDungeon.actionManager.addToTop(new VFXAction(AbstractDungeon.player, new ScreenOnFireEffect(), 1.0F));
            this.addToBot(new GainBlockAction(AbstractDungeon.player,6));
            //消耗蕾克拉
            this.flash();
            this.addToTop(new ApplyPowerAction(AbstractDungeon.player , AbstractDungeon.player ,new LexKela(AbstractDungeon.player , -lexkela.amount),-lexkela.amount));
        }

    }

    public void atStartOfTurn(){
        this.flash();
        this.addToTop(new ApplyPowerAction(this.owner,this.owner,new LexKela(this.owner,this.amount),this.amount));
    }
}
