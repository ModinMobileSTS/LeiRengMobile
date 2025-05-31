package ninja.powers;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.android.mods.AssetLoader;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class ThreeDuuzPower extends AbstractPower {
    public static final String POWER_ID = "ThreeDuuzPower";
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("ThreeDuuzPower");
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public ThreeDuuzPower(AbstractCreature owner) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = -1;
        this.updateDescription();
        this.type = PowerType.BUFF;

        String path128 = "img/powers_Ninja/3Duuz84.png";
        String path48 = "img/powers_Ninja/3Duuz32.png";
        this.region128 = new TextureAtlas.AtlasRegion( AssetLoader.getTexture(Ninja.MOD_ID,getResourcePath(path128)), 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion( AssetLoader.getTexture(Ninja.MOD_ID,getResourcePath(path48)), 0, 0, 32, 32);

        this.updateDescription();
    }

    public void updateDescription() {

        this.description = powerStrings.DESCRIPTIONS[0] + this.amount + powerStrings.DESCRIPTIONS[1];


    }
    
    public void onApplyPower(AbstractPower power, AbstractCreature target, AbstractCreature source) {
        // 检测是否是蕾克拉能力，且层数减少（消耗）

        if (power.ID.equals("LexKela") && power.amount < 0) {
            addToBot(new DrawCardAction( this.owner, this.amount)); // 抽牌
            CardCrawlGame.sound.play("3Duuz");
            this.flash();
        }

    }
}
