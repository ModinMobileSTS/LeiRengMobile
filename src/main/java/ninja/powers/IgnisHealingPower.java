package ninja.powers;

import ninja.actions.PlaySoundAction;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.android.mods.AssetLoader;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class IgnisHealingPower extends AbstractPower {
    public static final String POWER_ID = "IgnisHealingPower";
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("IgnisHealingPower");
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public IgnisHealingPower(AbstractCreature owner) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = -1;
        this.updateDescription();
        this.type = PowerType.DEBUFF;

        String path128 = "img/powers_Ninja/IgnisHealingPower84.png";
        String path48 = "img/powers_Ninja/IgnisHealingPower32.png";
        this.region128 = new TextureAtlas.AtlasRegion( AssetLoader.getTexture(Ninja.MOD_ID,getResourcePath(path128)), 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion( AssetLoader.getTexture(Ninja.MOD_ID,getResourcePath(path48)), 0, 0, 32, 32);

        this.updateDescription();
    }

    public void atStartOfTurn(){
        this.flash();
        this.addToBot(new PlaySoundAction("Die!Worm"));
        this.addToBot(new DamageAction(this.owner , new DamageInfo(this.owner, 20 , DamageInfo.DamageType.HP_LOSS) , AbstractGameAction.AttackEffect.FIRE));
        this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, "IgnisHealingPower"));
    }
    
    public void updateDescription() {

        this.description = powerStrings.DESCRIPTIONS[0] + 20 + powerStrings.DESCRIPTIONS[1];


    }
}
