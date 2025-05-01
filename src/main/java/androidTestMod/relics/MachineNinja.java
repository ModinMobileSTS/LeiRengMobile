package androidTestMod.relics;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomRelic;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class MachineNinja extends CustomRelic {
    public static final String ID = "MachineNinja";
    private static final String IMG = "img/relics_Ninja/MachineNinja.png";
    private static final String IMG_OTL = "img/relics_Ninja/outline/MachineNinja.png";
    private static final int AMOUNT = 3;

    public MachineNinja() {
        super(ID, ImageMaster.loadImage(IMG), ImageMaster.loadImage(IMG_OTL), RelicTier.BOSS, LandingSound.SOLID);
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
        if ( card.hasTag(CardTags.NINJUTSU) ) {
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
