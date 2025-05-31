package ninja.powers;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.android.mods.AssetLoader;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class MummyPower extends AbstractPower {
    public static final String POWER_ID = "MummyPower";
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("MummyPower");
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public MummyPower(AbstractCreature owner, int amount) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = amount;
        this.updateDescription();
        this.type = PowerType.BUFF;

        String path128 = "img/powers_Ninja/MummyPower84.png";
        String path48 = "img/powers_Ninja/MummyPower32.png";
        this.region128 = new TextureAtlas.AtlasRegion( AssetLoader.getTexture(Ninja.MOD_ID,getResourcePath(path128)), 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion( AssetLoader.getTexture(Ninja.MOD_ID,getResourcePath(path48)), 0, 0, 32, 32);

        this.updateDescription();
    }

    public void updateDescription() {
            this.description = powerStrings.DESCRIPTIONS[0] + this.amount + powerStrings.DESCRIPTIONS[1];


    }

    public void onApplyPower(AbstractPower power, AbstractCreature target, AbstractCreature source){
        // 检测是否是蕾克拉能力，且层数减少（消耗）
        if ((power.ID.equals("LexKela") && power.amount < 0)) {
            CardCrawlGame.sound.play("JRMummy");
            addToBot(new GainBlockAction(AbstractDungeon.player,this.amount)); // 回能
            this.flash();
        }
    }
}
