package ninja.powers;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.android.mods.AssetLoader;
import ninja.Ninja;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class IRepresentShinobiPower extends AbstractPower {
    public static final String POWER_ID = "IRepresentShinobiPower";
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("IRepresentShinobiPower");
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public IRepresentShinobiPower(AbstractCreature owner , int amount) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = amount;
        this.updateDescription();
        this.type = PowerType.BUFF;

        String path128 = "img/powers_Ninja/IRepresentShinobiPower84.png";
        String path48 = "img/powers_Ninja/IRepresentShinobiPower32.png";
        this.region128 = new TextureAtlas.AtlasRegion( AssetLoader.getTexture(Ninja.MOD_ID,path128), 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion( AssetLoader.getTexture(Ninja.MOD_ID,path48), 0, 0, 32, 32);

        this.updateDescription();
    }

    public void onApplyPower(AbstractPower power, AbstractCreature target, AbstractCreature source){
        // 检测是否是蕾克拉能力，且层数减少（消耗）
        if ((power.ID.equals("LexKela") && power.amount < 0)) {
                        addToBot(new GainEnergyAction(this.amount)); // 回能
            this.flash();
        }
    }

    public void updateDescription() {

        this.description = powerStrings.DESCRIPTIONS[0] ;


    }
}
