package ninja.relics;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomRelic;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.android.mods.AssetLoader;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;

public class MachineNinja extends CustomRelic {
    public static final String ID = "MachineNinja";
    private static final String IMG = "img/relics_Ninja/MachineNinja.png";
    private static final String IMG_OTL = "img/relics_Ninja/outline/MachineNinja.png";
    private static final int AMOUNT = 3;

    public MachineNinja() {
        super(ID, AssetLoader.getTexture(Ninja.MOD_ID,Ninja.getResourcePath(IMG)), AssetLoader.getTexture(Ninja.MOD_ID,Ninja.getResourcePath(IMG_OTL)), RelicTier.BOSS, LandingSound.SOLID);
    }

    public void onEquip() {
        ++AbstractDungeon.player.energy.energyMaster;
    }

    public void onUnequip() {
        --AbstractDungeon.player.energy.energyMaster;
    }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

    public void onUseCard(AbstractCard card, UseCardAction action){
        AbstractPower lexkela = AbstractDungeon.player.getPower("LexKela");
        if ( card.hasTag(AbstractCard.CardTags.NINJUTSU) ) {
            if(!AbstractDungeon.player.hasPower("DimDeadTreePower")) {
                CardCrawlGame.sound.play("machine");
                this.flash();
            }
        }
    }

    public AbstractRelic makeCopy() {
        return new MachineNinja();
    }
}
