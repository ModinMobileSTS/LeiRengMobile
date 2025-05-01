package ninja.cards;

import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import ninja.powers.ScarePower;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;

public class ScareForm extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("ScareForm");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/ScareForm.png";
    public static final String ID = "ScareForm";

    public ScareForm(){
        super (ID, NAME,Ninja.getResourcePath( IMG_PATH), 3, DESCRIPTION, CardType.POWER, CardColorEnum.SILVER, CardRarity.RARE, CardTarget.SELF);
        this.tags.add(CardTags.NINJUTSU);
    }

    public void use(AbstractPlayer p, AbstractMonster m ){
                this.addToBot(new ApplyPowerAction(p,p,new ScarePower(p,1),1));
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.selfRetain = true ;
            this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }

    public AbstractCard makeCopy(){
        return new ScareForm();
    }
}
