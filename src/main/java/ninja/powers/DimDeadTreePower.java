package ninja.powers;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.android.mods.AssetLoader;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class DimDeadTreePower extends AbstractPower {
    public static final String POWER_ID = "DimDeadTreePower";
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("DimDeadTreePower");
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public DimDeadTreePower(AbstractCreature owner) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = -1;
        this.updateDescription();
        this.type = PowerType.BUFF;

        String path128 = "img/powers_Ninja/DimDeadTreePower84.png";
        String path48 = "img/powers_Ninja/DimDeadTreePower32.png";
        this.region128 = new TextureAtlas.AtlasRegion( AssetLoader.getTexture(Ninja.MOD_ID,getResourcePath(path128)), 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion( AssetLoader.getTexture(Ninja.MOD_ID,getResourcePath(path48)), 0, 0, 32, 32);

        this.updateDescription();
    }

    @Override
    public void onUseCard(AbstractCard card, UseCardAction action) {
        if ((card.hasTag(AbstractCard.CardTags.NINJUTSU)||card.cardID == "YiCut" )){
            this.flash();
            this.addToBot(new RemoveSpecificPowerAction(AbstractDungeon.player,AbstractDungeon.player,"DimDeadTreePower"));
        }
    }

    public void updateDescription() {

        this.description = powerStrings.DESCRIPTIONS[0];


    }
}
