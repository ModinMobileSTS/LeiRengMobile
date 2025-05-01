package androidTestMod.cards;

import androidTestMod.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import androidTestMod.powers.LexKela;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.ArrayList;

public class EclipseMistBlade extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("EclipseMistBlade");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/EclipseMistBlade.png";
    public static final String ID = "EclipseMistBlade";

    public EclipseMistBlade(){
        super (ID, NAME, IMG_PATH, 1, DESCRIPTION, CardType.SKILL, CardColorEnum.SILVER, CardRarity.UNCOMMON, CardTarget.SELF);
        this.baseBlock = 9;
        this.tags.add(CardTagsEnum.BLADE);
    }

    public void use(AbstractPlayer p, AbstractMonster m ){
        this.addToBot(new GainBlockAction(p,this.block));
        CardCrawlGame.sound.play("EclipseMistBlade");
        ArrayList<AbstractCard> cardsToExhaust = new ArrayList();

        for(AbstractCard c : AbstractDungeon.player.hand.group) {
            if (  (c != null  &&  !c.hasTag(CardTagsEnum.BLADE)) || c.cardID == "DeathGodBlade") {
                if(c.cardID != "Shiv"){
                    cardsToExhaust.add(c);
                }

            }
        }

        for(AbstractCard c : cardsToExhaust) {
            this.addToTop(new ApplyPowerAction(p,p,new LexKela(p,1),1));
        }

        for(AbstractCard c : cardsToExhaust) {
            this.addToTop(new ExhaustSpecificCardAction(c, AbstractDungeon.player.hand));
        }
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeBlock(3);
        }
    }

    public AbstractCard makeCopy(){
        return new EclipseMistBlade();
    }
}
