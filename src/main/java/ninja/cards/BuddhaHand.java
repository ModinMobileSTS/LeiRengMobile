package ninja.cards;

import ninja.actions.NinjutsuAction;
import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;
import com.megacrit.cardcrawl.powers.VulnerablePower;

public class BuddhaHand extends CustomCard {private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("BuddhaHand");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/BuddhaHand.png";
    public static final String ID = "BuddhaHand";

    public BuddhaHand(){
        super (ID, NAME,Ninja.getResourcePath( IMG_PATH), 1, DESCRIPTION, CardType.ATTACK, CardColorEnum.SILVER, CardRarity.UNCOMMON, CardTarget.ENEMY);
        this.tags.add(CardTags.HAND);
        this.tags.add(CardTags.NINJUTSU);
        this.baseDamage = 10;
        this.baseMagicNumber = 2;
        this.magicNumber = this.baseMagicNumber;
        this.exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m ){
        this.addToTop(new DamageAction(m,new DamageInfo(p , this.damage , DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        this.addToBot(new ApplyPowerAction(m,p,new VulnerablePower(m,this.magicNumber,false),this.magicNumber));
        this.addToBot(new NinjutsuAction(p,new GainEnergyAction(2),1,"BuddhaHand"));
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeDamage(3);
            this.upgradeMagicNumber(1);
        }
    }

    public AbstractCard makeCopy(){
        return new BuddhaHand();
    }
}
