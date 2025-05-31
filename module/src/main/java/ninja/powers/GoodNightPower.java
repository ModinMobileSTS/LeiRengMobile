package ninja.powers;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.watcher.PressEndTurnButtonAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.android.mods.AssetLoader;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

public class GoodNightPower extends AbstractPower {
    public static final String POWER_ID = "GoodNightPower";
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("GoodNightPower");
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public GoodNightPower(AbstractCreature owner, int amount) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = amount;
        this.updateDescription();
        this.type = PowerType.BUFF;

        String path128 = "img/powers_Ninja/GoodNightPower84.png";
        String path48 = "img/powers_Ninja/GoodNightPower32.png";
        this.region128 = new TextureAtlas.AtlasRegion( AssetLoader.getTexture(Ninja.MOD_ID,getResourcePath(path128)), 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion( AssetLoader.getTexture(Ninja.MOD_ID,getResourcePath(path48)), 0, 0, 32, 32);

        this.updateDescription();
    }

    public void atStartOfTurn() {
        super.atStartOfTurn();
        addToTop((AbstractGameAction)new PressEndTurnButtonAction());
        this.amount--;
        AbstractPlayer p = AbstractDungeon.player;

        int heal = p.maxHealth * 3 / 10;
        if (p.hasRelic("Regal Pillow")) heal += 15;
        if (p.hasRelic("Dream Catcher")) {
        AbstractRoom room = AbstractDungeon.getCurrRoom();
        room.addCardToRewards();
        }

        addToBot((AbstractGameAction)new HealAction((AbstractCreature)p, (AbstractCreature)p, heal));

        if (this.amount <= 0) {
            addToBot((AbstractGameAction)new RemoveSpecificPowerAction((AbstractCreature)AbstractDungeon.player, (AbstractCreature)AbstractDungeon.player, this.ID));
        }
    }

    public void updateDescription() {

        this.description = DESCRIPTIONS[0];
        this.type = PowerType.BUFF;

    }
}

