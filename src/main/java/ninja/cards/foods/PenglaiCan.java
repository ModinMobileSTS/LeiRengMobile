package ninja.cards.foods;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;

public class PenglaiCan extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("PenglaiCan");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/PenglaiCan.png";
    public static final String ID = "PenglaiCan";

    public PenglaiCan() {
        super(ID, NAME,Ninja.getResourcePath( IMG_PATH), 0, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCard.CardColor.COLORLESS, AbstractCard.CardRarity.SPECIAL, AbstractCard.CardTarget.SELF);
        this.baseMagicNumber = 3;
        this.magicNumber = baseMagicNumber;
        this.tags.add(CardTags.FOOD);
        this.exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m){
                this.addToBot(new ExhaustAction(this.magicNumber, false, true, true));
    }
    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeMagicNumber(2);
        }
    }

    public AbstractCard makeCopy(){
        return new PenglaiCan();
    }
}
