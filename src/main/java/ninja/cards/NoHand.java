package ninja.cards;

import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import ninja.powers.LexKela;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DiscardSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class NoHand extends CustomCard {

    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("NoHand");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/NoHand.png";
    public static final String ID = "NoHand";

    public NoHand(){
        super (ID, NAME,Ninja.getResourcePath( IMG_PATH), 0, DESCRIPTION, CardType.SKILL, CardColorEnum.SILVER, CardRarity.UNCOMMON, CardTarget.SELF);
        this.exhaust = true;
        this.baseMagicNumber = 1;
        this.magicNumber = this.baseMagicNumber;
    }

    @Override
    public void use(AbstractPlayer p,AbstractMonster m){
        int count=0;
                AbstractPower lexkela = p.getPower("LexKela");
        for(AbstractCard c : AbstractDungeon.player.hand.group) {
            if(c.hasTag(CardTags.HAND)) {
                this.addToTop(new DiscardSpecificCardAction(c));
                count++;
            }
        }
        this.addToBot(new ApplyPowerAction( p, p,new LexKela( p , count ), count ));
        this.addToBot(new GainEnergyAction(count));
        }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.exhaust = false;
            this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }

    public AbstractCard makeCopy(){
        return new NoHand();
    }

}
