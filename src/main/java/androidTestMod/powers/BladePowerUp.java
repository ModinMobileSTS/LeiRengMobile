package androidTestMod.powers;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class BladePowerUp extends AbstractPower{
    public static final String POWER_ID = "BladePowerUp";
    private static final PowerStrings powerStrings= CardCrawlGame.languagePack.getPowerStrings("BladePowerUp");
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public BladePowerUp(AbstractCreature owner, int amount) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = amount ;
        this.updateDescription();
        this.type = PowerType.BUFF;

        if (this.amount >= 999) {
            this.amount = 999;
        }

        String path128 = "img/powers_Ninja/BladePowerUp84.png";
        String path48 = "img/powers_Ninja/BladePowerUp32.png";
        this.region128 = new TextureAtlas.AtlasRegion(ImageMaster.loadImage(path128), 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion(ImageMaster.loadImage(path48), 0, 0, 32, 32);

        this.updateDescription();
    }

    public void stackPower(int stackAmount) {
        this.fontScale = 8.0F;
        this.amount += stackAmount;
    }

    @Override
    public float atDamageGive(float damage, DamageInfo.DamageType type, AbstractCard card) {
        if (card.hasTag(CardTagsEnum.BLADE) || card.cardID == "Shiv") { // 检测标签
            return damage + this.amount; // 每层+3点
        }
        return damage;
    }

    public void updateDescription() {

        this.description = DESCRIPTIONS[0]+this.amount+DESCRIPTIONS[1];
        this.type = PowerType.BUFF;

    }
}
