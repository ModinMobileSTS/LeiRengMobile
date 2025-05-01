package ninja.cards;

import ninja.actions.ScienceAction;
import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;

public class NamiLightning extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("NamiLightning");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/NamiLightning.png";
    public static final String ID = "NamiLightning";

    public NamiLightning() {
        super(ID, NAME,Ninja.getResourcePath( IMG_PATH), 4, DESCRIPTION, CardType.SKILL, CardColorEnum.SILVER, CardRarity.COMMON, CardTarget.SELF);
        this.baseMagicNumber =2;
        this.magicNumber = this.baseMagicNumber;
        this.tags.add(CardTags.SCIENCE);
    }

    public void use(AbstractPlayer p, AbstractMonster m){

                this.addToBot(new DrawCardAction(this.magicNumber));
        this.addToBot(new ScienceAction(p));
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeBaseCost(3);
        }
    }

}
