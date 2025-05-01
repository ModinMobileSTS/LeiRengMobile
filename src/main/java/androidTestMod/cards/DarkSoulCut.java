package androidTestMod.cards;

import androidTestMod.actions.DarkSoulCutAction;
import androidTestMod.actions.NinjutsuAction;
import androidTestMod.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class DarkSoulCut extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("DarkSoulCut");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/DarkSoulCut.png";
    public static final String ID = "DarkSoulCut";

    public DarkSoulCut(){
        super (ID, NAME, IMG_PATH, 0, DESCRIPTION, CardType.ATTACK, CardColorEnum.SILVER, CardRarity.RARE, CardTarget.ENEMY);
        this.baseMagicNumber = 3;
        this.magicNumber = this.baseMagicNumber;
        this.baseDamage=0;
        this.exhaust=true;
        this.tags.add(CardTags.NINJUTSU);
        this.tags.add(CardTagsEnum.BLADE);
        this.tags.add(CardTags.HEALING);
    }

    public void use(AbstractPlayer p, AbstractMonster m ){


        this.addToBot(new NinjutsuAction(p,new DarkSoulCutAction(m,3,this.damage,this.damage,new DamageInfo(p,this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.FIRE),3,"DarkSoulCut"));
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.selfRetain = true;
            this.rawDescription=cardStrings.UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }



    public AbstractCard makeCopy(){
        return new DarkSoulCut();
    }
}
