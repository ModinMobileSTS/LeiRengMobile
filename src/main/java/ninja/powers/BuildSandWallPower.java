package ninja.powers;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.android.mods.AssetLoader;
import ninja.Ninja;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class BuildSandWallPower extends AbstractPower {
    public static final String POWER_ID = "BuildSandWallPower";
    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("BuildSandWallPower");
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public BuildSandWallPower(AbstractCreature owner) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount =-1;
        this.updateDescription();
        this.type = PowerType.BUFF;

        String path128 = "img/powers_Ninja/BuildSandWallPower84.png";
        String path48 = "img/powers_Ninja/BuildSandWallPower32.png";
        this.region128 = new TextureAtlas.AtlasRegion( AssetLoader.getTexture(Ninja.MOD_ID,path128), 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion( AssetLoader.getTexture(Ninja.MOD_ID,path48), 0, 0, 32, 32);

        this.updateDescription();
    }

    public void updateDescription() {

        this.description = powerStrings.DESCRIPTIONS[0];


    }
}
